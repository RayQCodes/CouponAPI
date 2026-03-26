package ECommerce.ecommerce;

import org.springframework.stereotype.Service;

@Service
public class RedeemCouponService {

    private final CouponRepository repo;

    public RedeemCouponService(CouponRepository repo) {
        this.repo = repo;
    }

    public String couponRedemption(RedeemRequestDTO request) {
        CouponDTO coupon = repo.findByCode(request.getCode()).orElse(null);

        if (coupon == null) {
            return "Coupon not found";
        }

        if (coupon.getUsageUsed() >= coupon.getUsageLimit()) {
            return "Coupon usage limit reached";
        }

        if (!coupon.getStatus().equalsIgnoreCase("active")) {
            return "Coupon is not active";
        }

        coupon.setUsageUsed(coupon.getUsageUsed() + 1);
        repo.save(coupon);

        return "Coupon redeemed";
    }
}