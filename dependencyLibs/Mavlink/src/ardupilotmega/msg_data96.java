/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE DATA96 PACKING
package com.MAVLink.ardupilotmega;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
        
/**
 * Data packet, size 96
 */
public class msg_data96 extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_DATA96 = 172;
    public static final int MAVLINK_MSG_LENGTH = 98;
    private static final long serialVersionUID = MAVLINK_MSG_ID_DATA96;


      
    /**
     * data type
     */
    public short type;
      
    /**
     * data length
     */
    public short len;
      
    /**
     * raw data
     */
    public short data[] = new short[96];
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_DATA96;
        
        packet.payload.putUnsignedByte(type);
        
        packet.payload.putUnsignedByte(len);
        
        
        for (int i = 0; i < data.length; i++) {
            packet.payload.putUnsignedByte(data[i]);
        }
                    
        
        if(isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a data96 message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.type = payload.getUnsignedByte();
        
        this.len = payload.getUnsignedByte();
        
         
        for (int i = 0; i < this.data.length; i++) {
            if(!payload.hasRemaining()) break;
            this.data[i] = payload.getUnsignedByte();
        }
                
        
        if(isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_data96() {
        msgid = MAVLINK_MSG_ID_DATA96;
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_data96(MAVLinkPacket mavLinkPacket) {
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_DATA96;
        this.isMavlink2 = mavLinkPacket.isMavlink2;
        unpack(mavLinkPacket.payload);        
    }

          
    /**
     * Returns a string with the MSG name and data
     */
    public String toString() {
        return "MAVLINK_MSG_ID_DATA96 - sysid:"+sysid+" compid:"+compid+" type:"+type+" len:"+len+" data:"+data+"";
    }
}
        