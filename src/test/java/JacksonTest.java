import com.jd.bluedragon.preseparate.model.PsOrderSeparate;
import org.junit.Test;

/**
 * zhongliang 2018/6/25.
 */
public class JacksonTest {


    public static void main(String[] args) {
        final String body = "{ \"id\" : 104657823, \"orderId\" : \"Q402595576\", \"partnerId\" : 282332, \"partnerName\" : \"西安北关站\", \"separateStatus\" : 9, \"provinceId\" : 27, \"cityId\" : 2376, \"countyId\" : 50235, \"townId\" : 0, \"fullAddress\" : \"【极】陕西西安市莲湖区北关十字华贸市政商厦A座\", \"isJdShip\" : 0, \"orgId\" : 645, \"orderType\" : 0, \"shipType\" : 0, \"paymentType\" : 0, \"orderBulk\" : 1608.86, \"orderWeight\" : 0.61, \"codSupport\" : 0, \"cky2\" : 763, \"sendPay\" : \"40000006200000002000000002001400030000100000000001600000000001030000000000000000000000000000000101000000000000000000000000000000000000000000000000000000000000000000000000000030000000000100420000100010\", \"separateType\" : 1, \"luxuryFlag\" : 0, \"errCount\" : 0, \"totalPrice\" : 0.0, \"type\" : 2, \"zdType\" : 0, \"paymentWay\" : 0, \"shipmentId\" : \"L_206875078\", \"daxueShipType\" : 0, \"storeId\" : 612, \"customerName\" : \"佟芳\", \"telphone\" : \"18092139373\", \"oldPartnerId\" : 0, \"fetchNum\" : 0, \"preState\" : 0, \"road\" : \"2\", \"addressStationType\" : 0, \"pickupSign\" : \"00000000000000000000000000000000000000000000000000\", \"manu\" : false, \"transferStationId\" : 0, \"queueNum\" : 0, \"topNum\" : 0, \"currentQueueNum\" : 0, \"queryOrgId\" : 0 }";
        for (int i = 0; i <100 ; i++) {
            new Thread(new Runnable() {
                public void run() {
                    PsOrderSeparate ps = JsonUtil.jsonToBeanFormated(body, PsOrderSeparate.class);
                    System.out.println(ps);
                }
            }).start();

        }
    }


}
