package ECommerce.ecommerce;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final ViewService viewService;
    private final UpdateService updateService;
    private final CreateService createService;
    private final ForfeitService forfeitService;
    private final RedeemCouponService redeemCouponService;

    public CouponController(ViewService viewService,
                            UpdateService updateService,
                            CreateService createService,
                            ForfeitService forfeitService,
                            RedeemCouponService redeemCouponService) {
        this.viewService = viewService;
        this.updateService = updateService;
        this.createService = createService;
        this.forfeitService = forfeitService;
        this.redeemCouponService = redeemCouponService;
    }

    @GetMapping("/viewAll")
    public List<CouponDTO> viewAll() {
        return viewService.viewAllCoupons();
    }

    @GetMapping("/viewByStatus/{status}")
    public List<CouponDTO> viewByStatus(@PathVariable String status) {
        return viewService.viewCouponWithStatus(status);
    }

    @GetMapping("/viewByCode/{code}")
    public CouponDTO viewByCode(@PathVariable String code) {
        return viewService.viewCouponByCode(code);
    }

    @PostMapping("/create")
    public String createCoupon(@RequestBody CouponDTO couponDTO) {
        return createService.createCoupon(couponDTO);
    }

    @PutMapping("/update")
    public String updateCoupon(@RequestBody CouponDTO couponDTO) {
        return updateService.updateCoupon(couponDTO);
    }

    @PutMapping("/forfeit/{code}")
    public String forfeitCoupon(@PathVariable String code) {
        return forfeitService.forfeitCoupon(code);
    }

    @PostMapping("/redeem")
    public String redeemCoupon(@RequestBody RedeemRequestDTO redeemRequest) {
        return redeemCouponService.couponRedemption(redeemRequest);
    }
}