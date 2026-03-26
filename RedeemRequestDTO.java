package ECommerce.ecommerce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class RedeemRequestDTO {


    //usageused, usagelimit , username , email

    private String username;
    private String email;
    private int UsageUsed;
    private int UsageLimit;
    private String code;






}
