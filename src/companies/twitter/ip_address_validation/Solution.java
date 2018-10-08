package companies.twitter.ip_address_validation;

/**
 * Created by naco_siren on 11/20/17.
 */
public class Solution {
    public static void main(String[] args) {
        String[] r1 = checkIP(new String[] {
                "This is junk.",
                "121.18.19.20",
                "2001:0db8:0000:0000:0000:ff00:0042:8329",
                "3:db8:0:01:F:ff0:0042:8329"
        });

        return;
    }

    static String[] checkIP(String[] ips) {
        int N = ips.length;
        String[] outputs = new String[N];
        for (int i = 0; i < N; i++) {
            String ip = ips[i];
            if (isIPv4(ip.toLowerCase())) {
                outputs[i] = "IPv4";
            } else if (isIPv6(ip.toLowerCase())) {
                outputs[i] = "IPv6";
            } else {
                outputs[i] = "Neither";
            }
        }
        return outputs;
    }

    static boolean isIPv4(String ip) {
        /* Split into four integers */
        String[] parts = ip.split("\\.");
        if (parts.length != 4)
            return false;

        /* Check if each part can be parsed into integer */
        for (String part : parts) {
            int num = -1;
            try {
                num = Integer.parseInt(part);
            } catch (Exception e) {
                return false;
            }

            if (num < 0 || num > 255)
                return false;
        }
        return true;
    }

    static boolean isIPv6(String ip) {
        /* Split into six integers */
        String[] parts = ip.split(":");
        if (parts.length != 8)
            return false;

        /* Check if each part can be parsed into integer */
        for (String part : parts) {
            /* Reconstruct the full presentation */
            int[] digits = new int[4];
            int len = part.length();
            if (len > 4)
                return false;
            for (int i = 0; i < len; i++) {
                int digit = hex2dec(part.charAt(len - 1 - i));
                if (digit == -1)
                    return false;
                digits[3 - i] =  digit;
            }
        }
        return true;
    }

    static int hex2dec(char ch) {
        if (ch >= '0' && ch <= '9') {
            return ch - '0';
        } else if (ch >= 'a' && ch <= 'f') {
            return ch - 'a' + 10;
        } else {
            return -1;
        }
    }
}
