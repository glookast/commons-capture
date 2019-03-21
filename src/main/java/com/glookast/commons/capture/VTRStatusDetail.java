package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = VTRStatusDetail.class)
public class VTRStatusDetail
{
    protected boolean local;  // true if VTR is in LOCAL control mode else REMOTE control mode
    protected boolean hardError; // true if there is a hardware error
    protected boolean tapeTrouble; // true if there are issues with tape
    protected boolean cassetteOut; // true if no cassette is threading on the DEVICE

    protected boolean play; // true when in PLAY, REC, EDIT or CAPSTAN OVERRIDE
    protected boolean rec; // true when in REC mode
    protected boolean fastForward; // true when in FAST FORWARD mode
    protected boolean rewind; // true when in REWIND mode
    protected boolean eject; // true when in EJECT mode
    protected boolean stop; // true when in STOP mode
    protected boolean tensionRelease; // true when in TENSION RELEASE mode
    protected boolean standbyOn; // true when in STANDBY ON mode

    protected boolean cueUpComplete; // true when cue-up operation is completed
    protected boolean still; // true when DEVICE is in the STILL mode of SHUTTLE/JOG/VAR. false when DEVICE is in STOP mode
    protected boolean tapeDirection; // shows the tape direction of DEVICE (0 = FWD, 1 = REV)
    protected boolean var; // true when DEVICE is in VAR or CAPSTAN OVERRIDE mode
    protected boolean jog; // true when DEVICE is in JOG mode
    protected boolean shuttle; // true when DEVICE is in SHUTTLE mode
    protected boolean tsoMode; // true when DEVICE is in CAPSTAN OVERRIDE mode
    protected boolean servoLock; // true when DEVICE is in condition that drum and capstan servos are locked in PLAY mode

    protected boolean prerollOrCueUp; //true when DEVICE goes in to PREROLL and CUE-UP mode

    protected boolean endOfTape; // true when DEVICE detects BEGIN or END of the cassette tape

    public VTRStatusDetail(VTRStatusDetail vtrStatusDetail)
    {
        this.local = vtrStatusDetail.local;
        this.hardError = vtrStatusDetail.hardError;
        this.tapeTrouble = vtrStatusDetail.tapeTrouble;
        this.cassetteOut = vtrStatusDetail.cassetteOut;
        this.play = vtrStatusDetail.play;
        this.rec = vtrStatusDetail.rec;
        this.fastForward = vtrStatusDetail.fastForward;
        this.rewind = vtrStatusDetail.rewind;
        this.eject = vtrStatusDetail.eject;
        this.stop = vtrStatusDetail.stop;
        this.tensionRelease = vtrStatusDetail.tensionRelease;
        this.standbyOn = vtrStatusDetail.standbyOn;
        this.cueUpComplete = vtrStatusDetail.cueUpComplete;
        this.still = vtrStatusDetail.still;
        this.tapeDirection = vtrStatusDetail.tapeDirection;
        this.var = vtrStatusDetail.var;
        this.jog = vtrStatusDetail.jog;
        this.shuttle = vtrStatusDetail.shuttle;
        this.tsoMode = vtrStatusDetail.tsoMode;
        this.servoLock = vtrStatusDetail.servoLock;
        this.prerollOrCueUp = vtrStatusDetail.prerollOrCueUp;
        this.endOfTape = vtrStatusDetail.endOfTape;
    }

    @JsonIgnore
    public VTRState getState()
    {
        if (rec) {
            return VTRState.RECORDING;
        } else if (play) {
            return VTRState.PLAYING;
        } else if (still) {
            return VTRState.PAUSED;
        } else if (stop) {
            return VTRState.STOPPED;
        } else if (fastForward) {
            return VTRState.FAST_FORWARD;
        } else if (rewind) {
            return VTRState.REWIND;
        } else if (shuttle) {
            return tapeDirection ? VTRState.SHUTTLE_REVERSE : VTRState.SHUTTLE_FORWARD;
        } else if (jog) {
            return tapeDirection ? VTRState.JOG_REVERSE : VTRState.JOG_FORWARD;
        } else if (var) {
            return tapeDirection ? VTRState.VAR_REVERSE : VTRState.VAR_FORWARD;
        } else if (endOfTape) {
            return VTRState.END_OF_TAPE;
        } else if (prerollOrCueUp) {
            return VTRState.PREROLL;
        } else if (cueUpComplete) {
            return VTRState.CUE_UP_COMPLETED;
        } else if (eject) {
            return VTRState.EJECTING;
        } else if (cassetteOut) {
            return VTRState.CASSETTE_OUT;
        }

        return VTRState.UNKNOWN;
    }
}
