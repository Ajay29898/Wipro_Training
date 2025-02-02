package in.sp.main.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.bank.Bank;

@RestController
@RequestMapping("/mybank")
public class BankRestController {

    @PostMapping("/bank")
    public String saveBank(@RequestBody Bank b) {
        System.out.println(b);
        return "Bank is saved";
    }

    @GetMapping("/bank/{bid}")
    public Bank getBank(@PathVariable Integer bid) {
        Bank b = new Bank(1001, "John Doe", 10000.0, "ABC Bank");
        return b;
    }

    @GetMapping("/banks")
    public List<Bank> getBanks() {
        Bank b1 = new Bank(1001, "John Doe", 10000.0, "ABC Bank");
        Bank b2 = new Bank(1002, "Jane Smith", 5000.0, "XYZ Bank");
        return Arrays.asList(b1, b2);
    }
}

