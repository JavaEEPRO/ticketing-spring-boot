package si.inspirited.domain.entity;

import org.springframework.lang.Nullable;
import si.inspirited.util.time.LocalDateTimeFormatter;
import si.inspirited.util.string.SpaceFiller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Nullable
    private String bus;
    @Nullable
    private int place;

    @Nullable
    private String owner;

    @Nullable
    private int price;
    @Nullable
    private LocalDateTime sold;

    @Nullable
    private String startPoint;
    @Nullable
    private String endPoint;

    @Nullable
    private LocalDateTime start;
    @Nullable
    private LocalDateTime arrive;

    @Nullable
    private boolean active;

    @Nullable
    public String getBus() {
        return bus;
    }
    public void setBus(String bus) {
        this.bus = bus;
    }

    @Nullable
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Nullable
    public int getPlace() {
        return place;
    }
    public void setPlace(int place) {
        this.place = place;
    }

    @Nullable
    public String getStartPoint() {
        return startPoint;
    }
    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    @Nullable
    public String getEndPoint() {
        return endPoint;
    }
    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    @Nullable
    public int getPrice() {
        return price;
    }
    public void setPrice(@Nullable int price) {
        this.price = price;
    }

    @Nullable
    public String getOwner() {
        return owner;
    }
    public void setOwner(@Nullable String owner) {
        this.owner = owner;
    }

    @Nullable
    public LocalDateTime getSold() {
        return sold;
    }
    public void setSold(@Nullable LocalDateTime sold) {
        this.sold = sold;
    }

    @Nullable
    public LocalDateTime getStart() {
        return start;
    }
    public void setStart(@Nullable LocalDateTime start) {
        this.start = start;
    }

    @Nullable
    public LocalDateTime getArrive() {
        return arrive;
    }
    public void setArrive(@Nullable LocalDateTime arrive) {
        this.arrive = arrive;
    }

    @Nullable
    public boolean isActive() {
        return active;
    }
    public void setActive(@Nullable boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        final int BOX_LENGTH = 62;
        String res;
        LocalDateTimeFormatter soldDate = new LocalDateTimeFormatter(this.getSold(), " at ");
        LocalDateTimeFormatter startDate = new LocalDateTimeFormatter(this.getStart(), " at ");
        LocalDateTimeFormatter arriveDate = new LocalDateTimeFormatter(this.getArrive(), " at ");
        StringBuilder stringBuilder = new StringBuilder();
        SpaceFiller filler = new SpaceFiller(BOX_LENGTH);

        stringBuilder.append("\n=========================== Ticket ============================");
        stringBuilder.append("\nin-memory entity link: { " + super.toString() + " }");
        stringBuilder.append("\nid: " + filler.generate(3, Long.toString(this.getId()))+ this.getId());
        stringBuilder.append("\nbus: " + filler.generate(4, this.getBus()) + this.getBus());
        stringBuilder.append("\nseat place: " + filler.generate(11, Long.toString(this.getPlace())) + this.getPlace());
        stringBuilder.append("\nticket owner: " + filler.generate(13, this.getOwner()) + this.getOwner());
        stringBuilder.append("\ndate of purchase: " + filler.generate(17, "" + soldDate) + soldDate);
        stringBuilder.append("\ndestination point: " + filler.generate(18, this.getEndPoint()) + this.getEndPoint());
        stringBuilder.append("\nwhen arrives: " + filler.generate(13, "" + arriveDate) + arriveDate);
        stringBuilder.append("\nstarts from: " + filler.generate(12, this.getStartPoint()) + this.getStartPoint());
        stringBuilder.append("\nstarts at: " + filler.generate(10, "" + startDate) + startDate);
        stringBuilder.append("\nprice: " + filler.generate(16, Long.toString(this.getPrice())) + this.getPrice() + " talant(s)");
        stringBuilder.append("\nis active: " + filler.generate(10, "" + this.isActive()) + this.isActive());
        stringBuilder.append("\n===============================================================");
        stringBuilder.append("\nGod, bless all passengers,drivers & developers in Jesus Christ!");
        stringBuilder.append("\n===============================================================\n");

        res = stringBuilder.toString();
        return res;
    }
}
