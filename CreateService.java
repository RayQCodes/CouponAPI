package ECommerce.ecommerce;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateService {

    //dI the repository
    CouponRepository newRepo;

    public CreateService(CouponRepository newRepo) {
        this.newRepo = newRepo;
    }
    public String createCoupon(CouponDTO coupon) {

        Optional<CouponDTO> optionalCoupon = newRepo.findByCode(coupon.getCode());

        if (optionalCoupon.isEmpty()) {
            newRepo.save(coupon);
            return "Coupon created";
        }

        return "Coupon already exists";
    }
}
