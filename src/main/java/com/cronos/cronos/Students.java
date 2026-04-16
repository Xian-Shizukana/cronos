
package com.cronos.cronos;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_students")
public class Students {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name= "fname", nullable = false, length = 255)
    private String fname;
    
    @Column(name= "mname", nullable = false, length = 255)
    private String mname;
    
    @Column(name= "lname", nullable = false, length = 255)
    private String lname;
    
    @Column(name= "strand", nullable = false, length = 255)
    private String strand;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getStrand() {
        return strand;
    }

    public void setStrand(String strand) {
        this.strand = strand;
    }
}
