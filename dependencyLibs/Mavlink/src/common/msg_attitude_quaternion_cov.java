/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE ATTITUDE_QUATERNION_COV PACKING
package com.MAVLink.common;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
        
/**
 * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed as quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0).
 */
public class msg_attitude_quaternion_cov extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_ATTITUDE_QUATERNION_COV = 61;
    public static final int MAVLINK_MSG_LENGTH = 72;
    private static final long serialVersionUID = MAVLINK_MSG_ID_ATTITUDE_QUATERNION_COV;


      
    /**
     * Timestamp (microseconds since system boot or since UNIX epoch)
     */
    public long time_usec;
      
    /**
     * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation)
     */
    public float q[] = new float[4];
      
    /**
     * Roll angular speed (rad/s)
     */
    public float rollspeed;
      
    /**
     * Pitch angular speed (rad/s)
     */
    public float pitchspeed;
      
    /**
     * Yaw angular speed (rad/s)
     */
    public float yawspeed;
      
    /**
     * Attitude covariance
     */
    public float covariance[] = new float[9];
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_ATTITUDE_QUATERNION_COV;
        
        packet.payload.putUnsignedLong(time_usec);
        
        
        for (int i = 0; i < q.length; i++) {
            packet.payload.putFloat(q[i]);
        }
                    
        
        packet.payload.putFloat(rollspeed);
        
        packet.payload.putFloat(pitchspeed);
        
        packet.payload.putFloat(yawspeed);
        
        
        for (int i = 0; i < covariance.length; i++) {
            packet.payload.putFloat(covariance[i]);
        }
                    
        
        if(isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a attitude_quaternion_cov message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.time_usec = payload.getUnsignedLong();
        
         
        for (int i = 0; i < this.q.length; i++) {
            if(!payload.hasRemaining()) break;
            this.q[i] = payload.getFloat();
        }
                
        
        this.rollspeed = payload.getFloat();
        
        this.pitchspeed = payload.getFloat();
        
        this.yawspeed = payload.getFloat();
        
         
        for (int i = 0; i < this.covariance.length; i++) {
            if(!payload.hasRemaining()) break;
            this.covariance[i] = payload.getFloat();
        }
                
        
        if(isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_attitude_quaternion_cov() {
        msgid = MAVLINK_MSG_ID_ATTITUDE_QUATERNION_COV;
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_attitude_quaternion_cov(MAVLinkPacket mavLinkPacket) {
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_ATTITUDE_QUATERNION_COV;
        this.isMavlink2 = mavLinkPacket.isMavlink2;
        unpack(mavLinkPacket.payload);        
    }

                
    /**
     * Returns a string with the MSG name and data
     */
    public String toString() {
        return "MAVLINK_MSG_ID_ATTITUDE_QUATERNION_COV - sysid:"+sysid+" compid:"+compid+" time_usec:"+time_usec+" q:"+q+" rollspeed:"+rollspeed+" pitchspeed:"+pitchspeed+" yawspeed:"+yawspeed+" covariance:"+covariance+"";
    }
}
        