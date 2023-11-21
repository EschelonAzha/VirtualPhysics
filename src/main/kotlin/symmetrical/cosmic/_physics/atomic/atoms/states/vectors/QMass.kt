package symmetrical.cosmic._physics.atomic.atoms.states.vectors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spatial.Beam
import symmetrical.cosmic._physics._subatomic.spatial.IBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

open class QMass(
    private val fermion: Fermion = Fermion(QMass::class),
) : Atom(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(QMass::class),
    )
    init {
        setMass(Beam(0))
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun red() : IBeam {
        return nucleons.getValueProton().red() as IBeam
    }
    fun setMass(value: IBeam) : QMass {
        setQuarkValue(value)
        return this
    }
}