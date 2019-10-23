//package ccom.world.remit.ecommerce.service;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.Date;
//
//import javax.inject.Inject;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.world.remit.ecommerce.dao.FunBooksAndVideosDao;
//import com.world.remit.ecommerce.daoImpl.FunBooksAndVideosDaoImpl;
//import com.world.remit.ecommerce.mode.response.PurchaseOrderResponse;
//import com.world.remit.ecommerce.model.Product;
//import com.world.remit.ecommerce.model.PurchaseOrderDetails;
//import com.world.remit.ecommerce.model.request.PurchaseOrderRequest;
//import com.world.remit.ecommerce.repository.UserMemberShipRepository;
//import com.world.remit.ecommerce.service.OrderProceeingServie;
//import com.world.remit.ecommerce.serviceimpl.OrderProcessingServiceImpl;
//import com.world.remit.ecommerce.types.Membership_Type;
//import com.world.remit.ecommerce.types.RequestType;
//
//@SpringBootTest
//public class OrderProceeingServieTest {
//	
//	@InjectMocks
//    OrderProceeingServie orderService;
//	
//	@InjectMocks
//	UserMemberShipRepository repository;
//	
//	@InjectMocks
//	FunBooksAndVideosDao funBooksAndVideosDao;
//	
//	@InjectMocks
//    private TestEntityManager testEntityManager;
//	
////	@Before
////    public void setup() {
////        mockMvc = MockMvcBuilders.standaloneSetup(orderService)
////                  .build();
////   }
//
//	
//	@Test
//    public void contains_NotValidId_Success() throws Exception {
//		
//		PurchaseOrderRequest request = new PurchaseOrderRequest();
//		request.setCustomerId(101);
//		request.setPurchaseOrderId("PR1234");
//		request.setRequestType(RequestType.MEMBERSHIP);
//		request.setTotalAmount(50.00);
//		request.setOrderDetails(new PurchaseOrderDetails(new Product(1234,"SKU1234"),Membership_Type.BOOK_CLUB,new Date(), new Date()));
//		PurchaseOrderResponse response = new PurchaseOrderResponse();
//		response.setActive(Boolean.TRUE);
//		if(orderService!=null) {
//			when(orderService.processOrder(request)).thenReturn(response);
//		}else{
//			orderService = new OrderProcessingServiceImpl();
//			when(orderService.processOrder(request)).thenReturn(response);
//			System.out.println("Service is NULL");
//		}
//		
//		 Boolean isActive = null;
//		if(orderService!=null) {
//			isActive = orderService.processOrder(request).isActive();
//		}else{
//			System.out.println("AService is Nukl");
//		}
//        assertEquals(Boolean.TRUE, isActive);
//    }
//	
////	@BeforeEach
////    void setMockOutput() throws Exception {
////		
////		PurchaseOrderRequest request = new PurchaseOrderRequest();
////		request.setCustomerId(101);
////		request.setPurchaseOrderId("PR1234");
////		request.setRequestType(RequestType.MEMBERSHIP);
////		request.setTotalAmount(50.00);
////		request.setOrderDetails(new PurchaseOrderDetails(new Product(1234,"SKU1234"),Membership_Type.BOOK_CLUB,new Date(), new Date()));
////		
////		PurchaseOrderResponse response = new PurchaseOrderResponse();
////		response.setActive(Boolean.TRUE);
////        when(orderService.processOrder(request)).thenReturn(response);
////    }
////	
////	@DisplayName("Test Mock helloService + helloRepository")
////    @Test
////    void testGet() throws Exception {
////		PurchaseOrderRequest request = new PurchaseOrderRequest();
////		request.setCustomerId(101);
////		request.setPurchaseOrderId("PR1234");
////		request.setRequestType(RequestType.MEMBERSHIP);
////		request.setTotalAmount(50.00);
////		request.setOrderDetails(new PurchaseOrderDetails(new Product(1234,"SKU1234"),Membership_Type.BOOK_CLUB,new Date(), new Date()));
////		
////        assertEquals("true", orderService.processOrder(request));
////    }
//
//}
