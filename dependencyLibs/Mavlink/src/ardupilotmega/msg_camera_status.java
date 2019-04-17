/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE CAMERA_STATUS PACKING
package com.MAVLink.ardupilotmega;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
        
/**
 * Camera Event
 */
public class msg_camera_status extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_CAMERA_STATUS = 179;
    public static final int MAVLINK_MSG_LENGTH = 29;
    private static final long serialVersionUID = MAVLINK_MSG_ID_CAMERA_STATUS;


      
    /**
     * Image timestamp (microseconds since UNIX epoch, according to camera clock)
     */
    public long time_usec;
      
    /**
     * Parameter 1 (meaning depends on event, see CAMERA_STATUS_TYPES enum)
     */
    public float p1;
      
    /**
     * Parameter 2 (meaning depends on event, see CAMERA_STATUS_TYPES enum)
     */
    public float p2;
      
    /**
     * Parameter 3 (meaning depends on event, see CAMERA_STATUS_TYPES enum)
     */
    public float p3;
      
    /**
     * Parameter 4 (meaning depends on event, see CAMERA_STATUS_TYPES enum)
     */
    public float p4;
      
    /**
     * Image index
     */
    public int img_idx;
      
    /**
     * System ID
     */
    public short target_system;
      
    /**
     * Camera ID
     */
    public short cam_idx;
      
    /**
     * See CAMERA_STATUS_TYPES enum for definition of the bitmask
     */
    public short event_id;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_CAMERA_STATUS;
        
        packet.payload.putUnsignedLong(time_usec);
        
        packet.payload.putFloat(p1);
        
        packet.payload.putFloat(p2);
        
        packet.payload.putFloat(p3);
        
        packet.payload.putFloat(p4);
        
        packet.payload.putUnsignedShort(img_idx);
        
        packet.payload.putUnsignedByte(target_system);
        
        packet.payload.putUnsignedByte(cam_idx);
        
        packet.payload.putUnsignedByte(event_id);
        
        if(isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a camera_status message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.time_usec = payload.getUnsignedLong();
        
        this.p1 = payload.getFloat();
        
        this.p2 = payload.getFloat();
        
        this.p3 = payload.getFloat();
        
        this.p4 = payload.getFloat();
        
        this.img_idx = payload.getUnsignedShort();
        
        this.target_system = payload.getUnsignedByte();
        
        this.cam_idx = payload.getUnsignedByte();
        
        this.event_id = payload.getUnsignedByte();
        
        if(isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_camera_status() {
        msgid = MAVLINK_MSG_ID_CAMERA_STATUS;
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_camera_status(MAVLinkPacket mavLinkPacket) {
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_CAMERA_STATUS;
        this.isMavlink2 = mavLinkPacket.isMavlink2;
        unpack(mavLinkPacket.payload);        
    }

                      
    /**
     * Returns a string with the MSG name and data
     */
    public String toString() {
        return "MAVLINK_MSG_ID_CAMERA_STATUS - sysid:"+sysid+" compid:"+compid+" time_usec:"+time_usec+" p1:"+p1+" p2:"+p2+" p3:"+p3+" p4:"+p4+" img_idx:"+img_idx+" target_system:"+target_system+" cam_idx:"+cam_idx+" event_id:"+event_id+"";
    }
}
        