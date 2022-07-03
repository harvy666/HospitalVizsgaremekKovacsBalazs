package com.example.hospitalvizsgaremek.data;


import com.example.hospitalvizsgaremek.testmodels.Patient;
import com.example.hospitalvizsgaremek.testmodels.Receipt;


import static com.example.hospitalvizsgaremek.data.TestDoctor.doctor1;

//USELESS CODE!
public interface TestPatient {

    Patient patient1=new Patient(1,"John Smith",32,doctor1,new Receipt(1,"Insulin",999));
//    Patient patient2=new Patient(1,"Agatha Horn",32,doctor2,new Receipt(1,"Tylenol",88));



}
