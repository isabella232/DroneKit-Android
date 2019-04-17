/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE FENCE_STATUS PACKING
package com.MAVLink.ardupilotmega;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
        
/**
 * Status of geo-fencing. Sent in extended status stream when fencing enabled
 */
public class msg_fence_status extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_FENCE_STATUS = 162;
    public static final int MAVLINK_MSG_LENGTH = 8;
    private static final long serialVersionUID = MAVLINK_MSG_ID_FENCE_STATUS;


      
    /**
     * time of last breach in milliseconds since boot
     */
    public long breach_time;
      
    /**
     * number of fence breaches
     */
    public int breach_count;
      
    /**
     * 0 if currently inside fence, 1 if outside
     */
    public short breach_status;
      
    /**
     * last breach type (see FENCE_BREACH_* enum)
     */
    public short breach_type;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_FENCE_STATUS;
        
        packet.payload.putUnsignedInt(breach_time);
        
        packet.payload.putUnsignedShort(breach_count);
        
        packet.payload.putUnsignedByte(breach_status);
        
        packet.payload.putUnsignedByte(breach_type);
        
        if(isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a fence_status message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.breach_time = payload.getUnsignedInt();
        
        this.breach_count = payload.getUnsignedShort();
        
        this.breach_status = payload.getUnsignedByte();
        
        this.breach_type = payload.getUnsignedByte();
        
        if(isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_fence_status() {
        msgid = MAVLINK_MSG_ID_FENCE_STATUS;
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_fence_status(MAVLinkPacket mavLinkPacket) {
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_FENCE_STATUS;
        this.isMavlink2 = mavLinkPacket.isMavlink2;
        unpack(mavLinkPacket.payload);        
    }

            
    /**
     * Returns a string with the MSG name and data
     */
    public String toString() {
        return "MAVLINK_MSG_ID_FENCE_STATUS - sysid:"+sysid+" compid:"+compid+" breach_time:"+breach_time+" breach_count:"+breach_count+" breach_status:"+breach_status+" breach_type:"+breach_type+"";
    }
}
        