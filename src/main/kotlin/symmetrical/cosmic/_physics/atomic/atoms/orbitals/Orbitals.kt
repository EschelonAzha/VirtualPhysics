package symmetrical.cosmic._physics.atomic.atoms.orbitals

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.balanced.quarks.Quark
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom

open class Orbitals : ParticleBeam, IOrbitals {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    object Static {
        const val VALUE     : Int = ParticleBeam.Static.LAST+1
        const val LAST      : Int = VALUE
    }
    private lateinit var __atom: Atom

    constructor() : super(0) {

    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun check(photon: Photon) : Unit {
        val classId = getLocalClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName)
        return;
    }
    override fun absorb(photon: Photon) : Photon {
        check(photon);

        clear()
        val remainder = super.absorb(photon.propagate())
        shrink()
        for (i in 0 until size()) {
            (get(i) as Electron).setOrbitals(this)
        }
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId()+super.emit().radiate()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Orbitals::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun getElectronValue() : Electron {
        if (size() == 0) {
            val electron = Electron()
            electron.setOrbitals(this)
            add(electron)
        }
        return get(Static.VALUE) as Electron
    }
    override fun electronSpin() : String {

        return getElectronValue().spin()
    }
    override fun electronValue() : Any? {
        return getElectronValue().wavelength()
    }
    override fun electronValueStr() : String {
        return getElectronValue().wavelengthStr()
    }
    override fun getElectronSpin() : Spin {
        return getElectronValue().getSpin()
    }
    override fun getElectronWavelength() : Any? {
        return getElectronValue().getWavelength()
    }
    override fun getElectronPhoton() : Photon {
        return getElectronValue().getPhoton()
    }
    override fun setElectronSpin(spin: Spin) : Atom {
        getElectronValue().setSpin(spin)
        return __atom
    }
    override fun setElectronValue(value:Any?) : ZBoson {
        val zBoson = Quark.Args(value)
        getElectronValue().setWavelength(value)
        return zBoson
    }

    override fun setAtom(atom:Atom) : Atom {
     //   add(Electron().i(atom))
        this.__atom = atom
        return atom
    }
}