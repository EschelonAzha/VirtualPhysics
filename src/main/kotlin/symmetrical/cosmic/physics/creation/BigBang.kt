package symmetrical.cosmic.physics.creation


import asymmetrical.physics.machine.threads.Cores

class BigBang  {
    constructor()

    private lateinit var universe       : Universe
    var cores                           : Cores = Cores()
    fun i(universe: Universe) : BigBang {
        this.universe = universe;
        //  BootConfig.UNIVERSE = universe
        return this;
    }

    fun run() : Unit {
        // this runs a console app
        this.universe.run()
    }
    fun runUI() : Unit {
        // this starts and runs the browser UI
        //   Application.launch(FxLauncher::class.java)
    }

}