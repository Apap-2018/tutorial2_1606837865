package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViralGenerator {
	@RequestMapping("/generator")
	//"value" di dalam request param menangkap nilai yang dari url
	public String index(@RequestParam (value = "a", required = false, defaultValue = "0") String number1, @RequestParam (value = "b", required = false, defaultValue = "0") String number2, Model model) {
		//required false = kita bisa menggunakan routing generator tanpa harus membuat parameter
		//default value = menginisiasi value
		int num1 = Integer.parseInt(number1);
		int num2 = Integer.parseInt(number2);	
		String a = "hm";
		if (num2 == 0) {                            //jika b = 0
			if (num1 == 0) {                         //jika a = 0
				model.addAttribute("htmlRest",a);    //langsung print "hm"
			}else {                                  //jika a banyak
				for (int i = 1 ; i < num1 ; i++) { 
					a += "m";                        //a mengindikasikan jumlah m, looping m berdasarkan a
				}
				model.addAttribute("htmlRest",a);         
			}
			
		}else {		                               //jika b banyak
			if (num1 == 0) {                         //jika a = 0
				for (int i = 1 ; i < num2 ; i++) {
					a+=" hm";                       //b mengindikasikan hm, looping hm berdasarkan 
				}
				model.addAttribute("htmlRest",a);
			}else {                                //jika a banyak
				String temp = "";                   //initiate fixed temp
				for(int i = 0 ; i <num2 ; i++ ) {        //looping b terlebih dahulu
					temp += " hm";
					for(int j = 1 ; j < num1 ; j++) {  //looping a 
						temp += "m";
					}
				}
				model.addAttribute("htmlRest",temp);
			}
		}
		model.addAttribute("a", num1); //mengirim a ke html
		model.addAttribute("b", num2); //mengirim b ke html
		return "viralgen";
	}
}
