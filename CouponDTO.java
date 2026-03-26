package ECommerce.ecommerce;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "coupons")
public class CouponDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;
    private String discountType;
    private int minOrderAmount;
    private Double maxDiscountAmount;
    private String startDate;
    private String endDate;
    private int usageLimit;
    private int usageUsed;
    private String status = "active";
}
