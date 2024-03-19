package app122;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DragonBallDTO { // Data Transfer Object
	private int currentPage;
	private int itemsPerPage;
	private int totalPages;
	private List<DragonBall> items;
}