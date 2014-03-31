<?php
require_once 'noiseinitial.php';
$myExample = new example();
// performs some basic operation
echo '<b>Attempt to perform basic operations</b><br />'."\n";
try {
    echo 'Your amp is <i>'.$myExample->giveMeSomeData('amp').'</i><br />'."\n";
    echo 'Your lat is <i>'.$myExample->giveMeSomeData('lat').'</i><br />'."\n";
    echo 'Your longt is <i>'.$myExample->giveMeSomeData('longt').'</i><br />'."\n";
    $myExample->changeYourState('I am using this function from the local environement');
    echo 'Your status request has been accepted<br />'."\n";
} catch (Exception $e) {
    echo nl2br($e->getMessage()).'<br />'."\n";
}
// performs some strategic operation, locally allowed
echo '<br /><b>Attempt to store strategic data</b><br />'."\n";
try {
    $myExample->writeSomething('Strategic string!');
    echo 'Strategic data succefully stored';
} catch (Exception $e) {
    echo nl2br($e->getMessage());
}
?>
