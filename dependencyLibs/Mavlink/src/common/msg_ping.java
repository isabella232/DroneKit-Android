/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE PING PACKING
package com.MAVLink.common;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
        
/**
 * A ping message either requesting or responding to a ping. This allows to measure the system latencies, including serial port, radio modem and UDP connections.
 */
public class msg_ping extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_PING = 4;
    public static final int MAVLINK_MSG_LENGTH = 14;
    private static final long serialVersionUID = MAVLINK_MSG_ID_PING;


      
    /**
     * Unix timestamp in microseconds or since system boot if smaller than MAVLink epoch (1.1.2009)
     */
    public long time_usec;
      
    /**
     * PING sequence
     */
    public long seq;
      
    /**
     * 0: request ping from all receiving systems, if greater than 0: message is a ping response and number is the system id of the requesting system
     */
    public short target_system;
      
    /**
     * 0: request ping from all receiving components, if greater than 0: message is a ping response and number is the system id of the requesting system
     */
    public short target_component;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_PING;
        
        packet.payload.putUnsignedLong(time_usec);
        
        packet.payload.putUnsignedInt(seq);
        
        packet.payload.putUnsignedByte(target_system);
        
        packet.payload.putUnsignedByte(target_component);
        
        if(isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a ping message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.time_usec = payload.getUnsignedLong();
        
        this.seq = payload.getUnsignedInt();
        
        this.target_system = payload.getUnsignedByte();
        
        this.target_component = payload.getUnsignedByte();
        
        if(isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_ping() {
        msgid = MAVLINK_MSG_ID_PING;
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_ping(MAVLinkPacket mavLinkPacket) {
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_PING;
        this.isMavlink2 = mavLinkPacket.isMavlink2;
        unpack(mavLinkPacket.payload);        
    }

            
    /**
     * Returns a string with the MSG name and data
     */
    public String toString() {
        return "MAVLINK_MSG_ID_PING - sysid:"+sysid+" compid:"+compid+" time_usec:"+time_usec+" seq:"+seq+" target_system:"+target_system+" target_component:"+target_component+"";
    }
}
        