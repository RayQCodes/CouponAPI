package ECommerce.ecommerce;

import org.springframework.stereotype.Service;

@Service
public class ForfeitService {

    private final CouponRepository repo;

    public ForfeitService(CouponRepository repo) {
        this.repo = repo;
    }

    public String forfeitCoupon(String code) {

        if (repo.findByCode(code).isEmpty()) {
            return "Coupon not found";
        }

        CouponDTO coupon = repo.findByCode(code).get();

        coupon.setStatus("forfeited");
        repo.save(coupon);

        return "Coupon forfeited";
    }
}