package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class CRLFTerminatedMomentum(
    private val fermion: IFermion = Fermion(),
) : AngularMomentum(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )
    private fun getLocalClassId() : String {
        return Absorber.getClassId(CRLFTerminatedMomentum::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun format(wavelength: Wavelength) : String {
        return Strings.crlfTerminated(wavelength.toString())
    }
}