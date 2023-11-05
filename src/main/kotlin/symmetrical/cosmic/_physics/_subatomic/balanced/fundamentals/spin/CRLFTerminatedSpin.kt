package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class CRLFTerminatedSpin : Spin {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    constructor() {

    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(CRLFTerminatedSpin::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun format(wavelength: Wavelength) : String {
        return Strings.crlfTerminated(wavelength.toString())
    }
}