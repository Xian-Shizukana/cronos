
package com.cronos.cronos;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalTime;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class CronosController {
    @Autowired
	private StudentRepository studentRepo;
    
    @Autowired
	private LogRepository logRepo;
    
    @GetMapping("/")
       public String showHomePage() {
          return "index";
        }
       
    @GetMapping("/attendancechecker")
        public String showAttendanceChecker(){
            return "achecker";
        }
        
    @GetMapping("/attendancelist")
    public String getUsers(Model model) {
        // Fetch all users from the database
        List<Students> students = studentRepo.findAll();

        // Add the users list to the model
        model.addAttribute("students", students);

        // Return the name of the HTML template to render
        return "alist";
    }
       
    @PostMapping("/attendance/submit")
        public String recordAttendance(@RequestParam("studentid") int studentid){
            String type;
            
            LocalTime now = LocalTime.now();
            
            if (now.isAfter(LocalTime.of(3, 59)) && now.isBefore(LocalTime.of(11, 1))) {
                type = "in"; // Between 4:00 AM and 11:00 AM
            } else {
                type = "out"; // Between 11:01 AM and 3:59 AM
            }
            
            Logs log = new Logs();
            
            log.setStudent_id(studentid);
            log.setType(type);
            
            logRepo.save(log);
            
            return "achecker";
        }
        
    @PostMapping("/submitDateTime")
    public String handleDateTime(@RequestParam("startingdate") String sdate, @RequestParam("endingdate") String edate, Model model) {
        
        // Parse the input string to LocalDateTime
        LocalDateTime sLDT = LocalDateTime.parse(sdate);
        LocalDateTime eLDT = LocalDateTime.parse(edate);
        
        List<Logs> logsInRange = logRepo.findByTimestampBetween(sLDT, eLDT);
        
        // Extract student IDs from logs
        List<Integer> studentIds = logsInRange.stream()
                                          .map(Logs::getStudent_id)
                                          .distinct() // Avoid duplicate IDs
                                          .toList();
        
        List<Students> students = studentRepo.findByIds(studentIds);
        
        model.addAttribute("students", students);

        return "alist";
    }
}
