package Easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author WilsonSong
 * @date 2019/1/9/009
 */
public class Code_929_UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> normalized = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@"); // split into local and domain parts.
            String[] local = parts[0].split("\\+"); // split local by '+'.
            normalized.add(local[0].replace(".", "") + "@" + parts[1]); // remove all '.', and concatenate '@' and domain.
        }
        return normalized.size();
    }
}
