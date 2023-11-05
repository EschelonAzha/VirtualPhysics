package symmetrical.cosmic._physics._creation


import asymmetrical.machine.threads.Cores
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._bitmaps.Bits64
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam


class BigBang {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    private lateinit var universe       : symmetrical.cosmic._physics._creation.Universe
    var cores                           : Cores = Cores()
    constructor() {
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(symmetrical.cosmic._physics._creation.BigBang::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i(universe: symmetrical.cosmic._physics._creation.Universe) : symmetrical.cosmic._physics._creation.BigBang {
        this.universe = universe;
        //  BootConfig.UNIVERSE = universe
        return this;
    }
    fun runUI() : Unit {
        // this starts and runs the browser UI
     //   Application.launch(FxLauncher::class.java)
    }

    fun run() : Unit {
        // this runs a console app
        this.universe.run()
    }

}