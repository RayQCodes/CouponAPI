package ECommerce.ecommerce;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewService {

    private final CouponRepository repo;

    public ViewService(CouponRepository repo) {
        this.repo = repo;
    }

    public List<CouponDTO> viewAllCoupons() {
        return repo.findAll();
    }

    public List<CouponDTO> viewCouponWithStatus(String status) {
        return repo.findByStatus(status);
    }

    public CouponDTO viewCouponByCode(String code) {
        CouponDTO coupon = repo.findByCode(code).orElse(null);

        if (coupon != null) {
            return coupon;
        }

        return null;
    }
}
