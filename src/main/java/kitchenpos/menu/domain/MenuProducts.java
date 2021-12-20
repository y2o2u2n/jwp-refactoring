package kitchenpos.menu.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import kitchenpos.common.Price;

@Embeddable
public class MenuProducts {
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "menu_id", nullable = false)
	private List<MenuProduct> values;

	protected MenuProducts() {
	}

	public static MenuProducts of(List<MenuProduct> values) {
		if (values == null || values.isEmpty()) {
			throw new IllegalArgumentException("메뉴 상품들은 한개 이상이어야 합니다.");
		}

		MenuProducts menuProducts = new MenuProducts();
		menuProducts.values = values;
		return menuProducts;
	}

	public List<MenuProduct> getValues() {
		return values;
	}

	public Price getTotalPrice() {
		return values.stream()
			.map(menuProduct -> {
				BigDecimal price = menuProduct.getProduct().getPrice().getValue();
				BigDecimal quantity = BigDecimal.valueOf(menuProduct.getQuantity().getValue());
				return price.multiply(quantity);
			})
			.reduce(BigDecimal::add)
			.map(Price::of)
			.get();
	}
}
