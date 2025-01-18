package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ua.lviv.lgs.domain.Bricks;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.dto.BucketDto;
import ua.lviv.lgs.service.BricksService;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.impl.BricksServiceImpl;
import ua.lviv.lgs.service.impl.BucketServiceImpl;

@WebServlet("/buckets")
public class BucketsController extends HttpServlet {

	private BucketService bucketService = BucketServiceImpl.getBucketService();
	private BricksService productService = BricksServiceImpl.getBricksService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Bucket> buckets = bucketService.readAll();
		Map<Integer, Bricks> idToProduct = productService.readAllMap();
		List<BucketDto> listOfBucketDtos = map(buckets, idToProduct);

		String json = new Gson().toJson(listOfBucketDtos);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	public List<BucketDto> map(List<Bucket> buckets, Map<Integer, Bricks> idToProduct) {

		return buckets.stream().map(bucket -> {
			BucketDto bucketDto = new BucketDto();
			bucketDto.bucketId = bucket.getId();
			bucketDto.purchaseDate = bucket.getPurchaseDate();

			Bricks bricks = idToProduct.get(bucket.getProductId());
			bucketDto.type = bricks.getType();
			bucketDto.pricePerUnit = bricks.getPricePerUnit();
			bucketDto.stock = bricks.getStock();

			return bucketDto;
		}).collect(Collectors.toList());

	}
}