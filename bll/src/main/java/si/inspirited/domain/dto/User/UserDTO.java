package si.inspirited.domain.dto.User;

import si.inspirited.util.string.SpaceFiller;
import si.inspirited.util.time.LocalDateTimeFormatter;

import javax.enterprise.inject.Model;
import java.time.LocalDateTime;

//@Model
public class UserDTO {

    private long id;

    private String name;

    private String firstLastMiddleName;

    private String phone;

    private String notifyEmails;

    private LocalDateTime creationDate;

    private LocalDateTime lastActivityDate;

    private boolean approved;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLastMiddleName() {
        return firstLastMiddleName;
    }

    public void setFirstLastMiddleName(String firstLastMiddleName) {
        this.firstLastMiddleName = firstLastMiddleName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNotifyEmails() {
        return notifyEmails;
    }

    public void setNotifyEmails(String notifyEmails) {
        this.notifyEmails = notifyEmails;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(LocalDateTime lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        String result;
        final int BOX_LENGTH = 62;

        LocalDateTimeFormatter lastActivityDate = new LocalDateTimeFormatter(this.getLastActivityDate(), " at ");
        LocalDateTimeFormatter creationDate = new LocalDateTimeFormatter(this.getCreationDate(), " at ");
        StringBuilder stringBuilder = new StringBuilder();
        SpaceFiller spaceFiller = new SpaceFiller(BOX_LENGTH);

        stringBuilder.append("\n============================ UserDTO ==========================");
        stringBuilder.append("\nin-memory entity link: { " + super.toString() + " }");
        stringBuilder.append("\nId: " + spaceFiller.generate(3, Long.toString(this.getId()))+ this.getId());
        stringBuilder.append("\nName: " + spaceFiller.generate(5, this.getName()) + this.getName());
        stringBuilder.append("\nFirst\\Last\\Middle name: " + spaceFiller.generate(23, this.getFirstLastMiddleName()) + this.getFirstLastMiddleName());
        stringBuilder.append("\nPh. number: " + spaceFiller.generate(11, this.getPhone()) + this.getPhone());
        stringBuilder.append("\nEmail: " + spaceFiller.generate(6, this.getNotifyEmails()) + this.getNotifyEmails());
        stringBuilder.append("\nCreation date: " + spaceFiller.generate(14, "" + creationDate) + creationDate);
        stringBuilder.append("\nLast activity was: " + spaceFiller.generate(18, "" + lastActivityDate) + lastActivityDate);
        stringBuilder.append("\nIs user approved: " + spaceFiller.generate(17, "" + this.isApproved()) + this.isApproved());
        stringBuilder.append("\n===============================================================");
        stringBuilder.append("\nGod, bless users and administrators in the name of Jesus Christ");
        stringBuilder.append("\n===============================================================\n");

        result = stringBuilder.toString();
        return result;
    }
}
