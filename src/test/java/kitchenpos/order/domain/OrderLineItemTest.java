package kitchenpos.order.domain;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kitchenpos.common.domain.Name;
import kitchenpos.common.domain.Price;
import kitchenpos.common.domain.Quantity;
import kitchenpos.menu.domain.Menu;
import kitchenpos.menu.domain.MenuProduct;
import kitchenpos.menu.domain.MenuProducts;
import kitchenpos.menugroup.domain.MenuGroup;
import kitchenpos.product.domain.Product;

@DisplayName("주문 항목")
class OrderLineItemTest {

	@DisplayName("생성")
	@Test
	void of() {
		// given
		Menu menu = Menu.of(
			Name.from("후라이드+후라이드"),
			Price.from(BigDecimal.valueOf(25000)),
			MenuGroup.from(Name.from("추천메뉴")),
			MenuProducts.from(Collections.singletonList(
				MenuProduct.of(
					Product.of(Name.from("후라이드치킨"), Price.from(BigDecimal.valueOf(17000))),
					Quantity.from(2L)))));
		Quantity quantity = Quantity.from(1L);

		// when
		OrderLineItem orderLineItem = OrderLineItem.of(menu, quantity);

		// then
		assertThat(orderLineItem.getMenu()).isEqualTo(menu);
		assertThat(orderLineItem.getQuantity()).isEqualTo(quantity);
	}
}
