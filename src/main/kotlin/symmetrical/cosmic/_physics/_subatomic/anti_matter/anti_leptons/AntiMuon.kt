package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

open class AntiMuon(
    private val fermion: IFermion = Fermion(),
) : AntiLepton(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiMuon::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : AntiMuon {
        super.i()
        return this
    }
}