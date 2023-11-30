package symmetrical.cosmic._physics._creation


import asymmetrical.machine.threads.Cores
import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


class BigBang  {
    constructor()

    private lateinit var universe       : Universe
    var cores                           : Cores = Cores()


    fun i(universe: Universe) : BigBang {
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