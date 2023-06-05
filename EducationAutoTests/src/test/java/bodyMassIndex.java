/* Функция расчёта индекса массы тела

Создайте проект Maven.
Подключите к нему JUnit.
Добавьте в проект функцию.
Составьте тест-кейсы по аналогии с ручным тестированием для функции ИМТ, опираясь на её ожидаемое поведение из аналитики.
Для этого примените привычные вам техники тест-дизайна.
Оформите их в виде автотестов JUnit.

Индекс массы тела — величина соответствия массы человека его росту. Значение косвенно показывает,
является ли масса недостаточной, нормальной или избыточной. ИМТ важен при определении показаний для лечения.

Рассчитывается по формуле:
IMT = m/(h*h), где m — масса тела в килограммах, h — рост в метрах.

Например:
масса человека = 75 кг,
рост = 180 см.
ИМТ = 75 / (1,8 * 1,8) = 23,14.

Функция расчёта результата должна возвращать следующее:

Для роста <= 0 см или > 350 см: «указан некорректный рост».
Для веса <= 0 или > 1000 кг: «указан некорректный вес».
Для ИМТ > 0 и <= 16: «выраженный дефицит массы тела».
Для ИМТ > 16 и ИМТ < 19: «недостаточная масса тела».
Для ИМТ >= 19 и ИМТ < 25: «нормальная масса тела».
Для ИМТ >= 25: «избыточная масса тела».
 */

import org.junit.Assert;
import org.junit.Test;

public class bodyMassIndex {
    @Test
    public void testNormalWeight() {
        String actualResult = getIMTResult ( 180f, 75f );
        Assert.assertEquals ( "нормальной массе тела", actualResult );
    }

    @Test
    public void testZeroHeigh() {
        String actualResult = getIMTResult ( 0f, 65f );
        Assert.assertEquals ( "указан некорректный рост", actualResult );
    }

    private String getIMTResult(Float heightCm, Float weightKg) {
        long userIndex = Math.round ( weightKg / Math.pow ( (heightCm / 100), 2 ) );
        String userResult = null;
        if (userIndex <= 16) {
            userResult = "выраженному дефициту массы тела";
        } else if (userIndex < 19) {
            userResult = "недостаточной массе тела";
        } else if (userIndex > 19 && userIndex < 25) {
            userResult = "нормальной массе тела";
        } else if (userIndex > 25) {
            userResult = "избыточной массе тела";
        }
        if (heightCm.equals ( 0.0f )) userResult += "указан некорректный рост";
        return userResult;
    }

}
