package symmetrical.cosmic._physics.atomic.atoms.nucleons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton

class Protons : ParticleBeam, IProtons {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    object Static {
        const val VALUE_PROTON  : Int  = ParticleBeam.Static.LAST + 1
        const val LAST          : Int  = VALUE_PROTON + 1
    }

    private lateinit var __nucleons   : Nucleons

    constructor() : super(1) {
        set(0, Proton().setProtons(this))
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
            (get(i) as Proton).setProtons(this)
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
        val classId = Absorber.getClassId(Protons::class)
        return classId
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun addProton(proton: Proton) : Proton {
        add(proton)
        return proton
    }
//
//    override fun findProton(purpose:String) : Int {
//        var i=0;
//        while (i<size()) {
//            val baryon = get(i) as Proton
//            if ((baryon.get(2) as Quark).red() == purpose) {
//                return i
//            }
//            i++
//        }
//        return -1
//    }
    override fun getAtomicNumber() : Int {
        return size()
    }
    override fun getProton(pos:Int) : Proton {
        return get(pos) as Proton
    }
//    override fun getProton(purpose:String) : Proton {
//        var pos = findProton(purpose)
//
//        if (pos!=-1)
//            return getProton(pos) as Proton
//
//        var proton = Proton()
//        proton.setPurpose(purpose)
//        addProton(proton)
//        return proton
//    }
    override fun getValueProton() : Proton {
        return get(Static.VALUE_PROTON) as Proton
    }
    override fun setNucleons(nucleons:Nucleons) : Nucleons {
        this.__nucleons = nucleons
        return nucleons
    }
    override fun setAtomicNumber(number:Int) : Nucleons {
        var i=size()
        while (i<number) {
            add(Baryon().Proton() as Baryon)
            i++
        }
        return __nucleons as Nucleons
    }
}