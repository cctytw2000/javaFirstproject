package tw.projectnumber35.firstproject;

public class Libero {

	private String Status;
	private String Position;
	private String FirstName;
	private String LastName;
	private String BatHand;
	private String ThrowHand;
	private int Height;
	private int Weight;
	private String BirthDate;
	private String BirthCity;
	private String BirthState;
	private String BirthCountry;

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getBatHand() {
		return BatHand;
	}

	public void setBatHand(String batHand) {
		BatHand = batHand;
	}

	public String getThrowHand() {
		return ThrowHand;
	}

	public void setThrowHand(String throwHand) {
		ThrowHand = throwHand;
	}

	public int getHeight() {
		return Height;
	}

	public void setHeight(int height) {
		Height = height;
	}

	public int getWeight() {
		return Weight;
	}

	public void setWeight(int weight) {
		Weight = weight;
	}

	public String getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}

	public String getBirthCity() {
		return BirthCity;
	}

	public void setBirthCity(String birthCity) {
		BirthCity = birthCity;
	}

	public String getBirthState() {
		return BirthState;
	}

	public void setBirthState(String birthState) {
		BirthState = birthState;
	}

	public String getBirthCountry() {
		return BirthCountry;
	}

	public void setBirthCountry(String birthCountry) {
		BirthCountry = birthCountry;
	}

	public Libero() {

	}

	public Libero(String Status, String Position, String FirstName, String LastName, String BatHand, String ThrowHand,
			int Height, int Weight, String BirthDate, String BirthCity, String BirthState, String BirthCountry) {
		this.Status = Status;
		this.Position = Position;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.BatHand = BatHand;
		this.ThrowHand = ThrowHand;
		this.Height = Height;
		this.Weight = Weight;
		this.BirthDate = BirthDate;
		this.BirthCity = BirthCity;
		this.BirthState = BirthState;
		this.BirthCountry = BirthCountry;

	}

	@Override
	public String toString() {
		return "Position:" + Position + "FirstName:" + FirstName + " LastName:" + LastName + " BatHand:" + BatHand
				+ " ThrowHand:" + ThrowHand + " Height:" + Height + " Weight:" + Weight + " BirthDate:" + BirthDate;
	}

}