package leetcode.LC_468;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.regex.Pattern;

/**
 * 468. Validate IP Address
 */
class Solution468 {
    static final String IPV4 = "IPv4";
    static final String IPV6 = "IPv6";
    static final String NEITHER = "Neither";

    String validIPAddress(String IP) {
        return validIPAddressApi(IP);
    }

    /**
     *
     * Approach #1: `InetAddress` API
     *
     */
    String validIPAddressApi(String IP) {
        try {
            return (InetAddress.getByName(IP) instanceof Inet6Address) ? IPV4: IPV6;
        } catch(Exception e) {
            return NEITHER;
        }
    }


    /**
     *
     * Approach #2: Regex
     *
     */
    String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    Pattern pattenIPv4 =
            Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

    String chunkIPv6 = "([0-9a-fA-F]{1,4})";
    Pattern pattenIPv6 =
            Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

    String validIPAddressRegex(String IP) {
        if (pattenIPv4.matcher(IP).matches()) return IPV4;
        return (pattenIPv6.matcher(IP).matches()) ? IPV6 : NEITHER;
    }
}
