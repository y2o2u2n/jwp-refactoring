package kitchenpos.menu.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kitchenpos.product.domain.Product;

@Entity
public class MenuProduct {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long seq;

	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id")
	private Product product;

	@Embedded
	private MenuProductQuantity quantity;

	protected MenuProduct() {
	}

	public static MenuProduct of(Product product, MenuProductQuantity quantity) {
		MenuProduct menuProduct = new MenuProduct();
		menuProduct.product = product;
		menuProduct.quantity = quantity;
		return menuProduct;
	}

	public Long getSeq() {
		return seq;
	}

	public Product getProduct() {
		return product;
	}

	public MenuProductQuantity getQuantity() {
		return quantity;
	}
}
