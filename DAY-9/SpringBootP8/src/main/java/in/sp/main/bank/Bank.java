package in.sp.main.bank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bank 
{
    private Integer accountId;
    private String accountHolderName;
    private Double balance;
    private String bankName;

    public Bank(Integer accountId, String accountHolderName, Double balance, String bankName) 
    {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.bankName = bankName;
    }

	@Override
    public String toString() {
        return "Bank [accountId=" + accountId + ", accountHolderName=" + accountHolderName + ", balance=" + balance + ", bankName=" + bankName + "]";
    }
}

