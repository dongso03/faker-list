package app122;

import java.util.List;

public class DragonBallService {

	private DragonBallDAO dao = new DragonBallDAO();

	public DragonBallDTO getDragonBallPage(int page, int pagePer) {
		int totalCount = dao.countAll();
		int totalPage = totalCount / pagePer;
		totalPage += totalCount % pagePer == 0 ? 0 : 1;

		List<DragonBall> list = dao.getAll(pagePer, pagePer * (page - 1));

		DragonBallDTO dto = DragonBallDTO.builder().totalPages(totalPage).currentPage(page).itemsPerPage(pagePer)
				.items(list).build();
		return dto;
	}
}
