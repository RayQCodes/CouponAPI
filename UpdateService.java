package ECommerce.ecommerce;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UpdateService {

    // DI Inject
    private final CouponRepository newRepo;

    public UpdateService(CouponRepository newRepo){
        this.newRepo = newRepo;
    }

    public String updateCoupon(CouponDTO couponDTO){

        Optional<CouponDTO> optionalCoupon = newRepo.findByCode(couponDTO.getCode());

        if (optionalCoupon.isEmpty()) {
            return "Coupon not found";
        }

        CouponDTO existingCoupon = optionalCoupon.get();

        existingCoupon.setDiscountType(couponDTO.getDiscountType());
        existingCoupon.setMinOrderAmount(couponDTO.getMinOrderAmount());
        existingCoupon.setMaxDiscountAmount(couponDTO.getMaxDiscountAmount());
        existingCoupon.setStartDate(couponDTO.getStartDate());
        existingCoupon.setEndDate(couponDTO.getEndDate());
        existingCoupon.setUsageLimit(couponDTO.getUsageLimit());
        existingCoupon.setUsageUsed(couponDTO.getUsageUsed());
        existingCoupon.setStatus(couponDTO.getStatus());

        newRepo.save(existingCoupon);

        return "update completed successfully!";
    }
}