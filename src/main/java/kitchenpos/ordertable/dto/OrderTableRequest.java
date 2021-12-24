package kitchenpos.ordertable.dto;

import kitchenpos.ordertable.domain.NumberOfGuests;
import kitchenpos.ordertable.domain.OrderTable;

public class OrderTableRequest {
	private int numberOfGuests;
	private boolean empty;

	public OrderTableRequest() {
	}

	public OrderTableRequest(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public OrderTableRequest(boolean empty) {
		this.empty = empty;
	}

	public OrderTableRequest(int numberOfGuests, boolean empty) {
		this.numberOfGuests = numberOfGuests;
		this.empty = empty;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public OrderTable toOrderTable() {
		return OrderTable.of(NumberOfGuests.from(numberOfGuests), empty);
	}
}
