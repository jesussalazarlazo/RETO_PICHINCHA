package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseExchangeDto {


    private String amount;
    private String originCurrency;
    private String destinationCurrency;
    private String amountResult;
    public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getOriginCurrency() {
		return originCurrency;
	}

	public void setOriginCurrency(String originCurrency) {
		this.originCurrency = originCurrency;
	}

	public String getDestinationCurrency() {
		return destinationCurrency;
	}

	public void setDestinationCurrency(String destinationCurrency) {
		this.destinationCurrency = destinationCurrency;
	}

	public String getAmountResult() {
		return amountResult;
	}

	public void setAmountResult(String amountResult) {
		this.amountResult = amountResult;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private String value;

    public ResponseExchangeDto() {}

    public ResponseExchangeDto(String amount, String originCurrency, String destinationCurrency, String amountResult, String value) {
        this.amount = amount;
        this.originCurrency = originCurrency;
        this.destinationCurrency = destinationCurrency;
        this.amountResult = amountResult;
        this.value = value;
    }


}
