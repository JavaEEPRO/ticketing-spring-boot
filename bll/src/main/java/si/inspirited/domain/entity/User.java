package si.inspirited.domain.entity;

import org.springframework.lang.Nullable;
import si.inspirited.util.string.SpaceFiller;
import si.inspirited.util.time.LocalDateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
//import org.springframework.security.core.userdetails.User;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Nullable
    public String name;

    @Nullable
    public String firstLastMiddleName;

    @Nullable
    public String phone;

    @Nullable
    public String notifyEmails;

    @Nullable
    public LocalDateTime creationDate;

    @Nullable
    public LocalDateTime lastActivityDate;

    @Nullable
    public boolean approved;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Nullable
    public String getName() {
        return name;
    }
    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public String getFirstLastMiddleName() {
        return firstLastMiddleName;
    }
    public void setFirstLastMiddleName(@Nullable String firstLastMiddleName) {
        this.firstLastMiddleName = firstLastMiddleName;
    }

    @Nullable
    public String getPhone() {
        return phone;
    }
    public void setPhone(@Nullable String phone) {
        this.phone = phone;
    }

    @Nullable
    public String getNotifyEmails() {
        return notifyEmails;
    }
    public void setNotifyEmails(@Nullable String notifyEmails) {
        this.notifyEmails = notifyEmails;
    }

    @Nullable
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(@Nullable LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Nullable
    public LocalDateTime getLastActivityDate() {
        return lastActivityDate;
    }
    public void setLastActivityDate(@Nullable LocalDateTime lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    @Nullable
    public boolean isApproved() {
        return approved;
    }
    public void setApproved(@Nullable boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        final int BOX_LENGTH = 62;
        String res;

        LocalDateTimeFormatter creationDate = new LocalDateTimeFormatter(this.getCreationDate(), " at ");
        LocalDateTimeFormatter lastActivityDate = new LocalDateTimeFormatter(this.getLastActivityDate(), " at ");

        StringBuilder stringBuilder = new StringBuilder();
        SpaceFiller filler = new SpaceFiller(BOX_LENGTH);

        stringBuilder.append("\n============================ User =============================");
        stringBuilder.append("\nin-memory entity link: { " + super.toString() + " }");
        stringBuilder.append("\nid: " + filler.generate(3, Long.toString(this.getId()))+ this.getId());
        stringBuilder.append("\nname: " + filler.generate(5, this.getName()) + this.getName());
        stringBuilder.append("\nfirst\\last\\middle name: " + filler.generate(23, this.getFirstLastMiddleName()) + this.getFirstLastMiddleName());
        stringBuilder.append("\nph. number: " + filler.generate(11, this.getPhone()) + this.getPhone());
        stringBuilder.append("\nemail: " + filler.generate(6, this.getNotifyEmails()) + this.getNotifyEmails());
        stringBuilder.append("\ncreation date: " + filler.generate(14, "" + creationDate) + creationDate);
        stringBuilder.append("\nlast activity was: " + filler.generate(18, "" + lastActivityDate) + lastActivityDate);
        stringBuilder.append("\nis user approved: " + filler.generate(17, "" + this.isApproved()) + this.isApproved());
        stringBuilder.append("\n===============================================================");
        stringBuilder.append("\nGod, bless users and administrators in the name of Jesus Christ");
        stringBuilder.append("\n===============================================================\n");

        res = stringBuilder.toString();
        return res;
    }
}
