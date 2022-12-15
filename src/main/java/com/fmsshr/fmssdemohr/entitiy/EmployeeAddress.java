package com.fmsshr.fmssdemohr.entitiy;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
public class EmployeeAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id", length = 100)
    private  Long addressId;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "city",length = 100)
    private String city;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "post_code", length = 100)
    private int postCode;

    @Column(name = "phone_number",length = 100)
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
