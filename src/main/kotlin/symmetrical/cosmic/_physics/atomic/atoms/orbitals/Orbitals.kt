package symmetrical.cosmic._physics.atomic.atoms.orbitals

import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom
/*
https://en.wikipedia.org/wiki/Atomic_orbital
 */
open class Orbitals(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(Orbitals::class, Orbitals::class),
) : ParticleBeam(),
    IMatterAntiMatter by matterAntiMatter,
    IOrbitals
{
    constructor() : this(
        MatterAntiMatter(Orbitals::class, Orbitals::class),
    ) init {
        add(Electron())
    }

    object Static {
        const val VALUE     : Int = ParticleBeam.Static.LAST+1
        const val LAST      : Int = VALUE
    }
    private lateinit var p_atom: Atom


    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        clear()
        var remainder = photon.propagate()
        remainder = super.absorb(remainder)

        for (i in 0 until size()) {
            (get(i) as Electron).setOrbitals(this)
        }
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    override fun getElectronValue() : Electron {
        if (size() == 0) {
            val electron = Electron()
            electron.setOrbitals(this)
            add(electron)
        }
        return get(Static.VALUE) as Electron
    }
    override fun electronSpin() : Boolean {

        return getElectronValue().spin()
    }
    override fun electronValue() : Any? {
        return getElectronValue().wavelength()
    }
    override fun electronValueStr() : String {
        return getElectronValue().wavelengthStr()
    }
    override fun getElectronPhoton() : Photon {
        return getElectronValue().getPhoton()
    }
    override fun getElectronSpin() : Spin {
        return getElectronValue().getSpin()
    }
    override fun getElectronWavelength() : Any? {
        return getElectronValue().getWavelength()
    }
    override fun setAtom(atom:Atom) : Atom {
        //   add(Electron().i(atom))
        this.p_atom = atom
        return atom
    }

    override fun setElectronSpin(spin: Spin) : Atom {
        getElectronValue().setSpin(spin)
        return p_atom
    }
    override fun setElectronValue(value:Any?) : ZBoson {
        val zBoson = Quark.Args(value)
        getElectronValue().setWavelength(value)
        return zBoson
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+
                super.emit().radiate()
    }
}