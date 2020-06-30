package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.MovieItem;

@NoArgsConstructor
public class AfishaManager {
  private MovieItem[] movies = new MovieItem[0]; // массив фильма
  private int moviesToReturn;// сколько элементов будет возвращено
  private int moviesToReturnDefault = 10;// элементов по умолчанию 10

  public AfishaManager(int moviesToReturn) {
    this.moviesToReturn = moviesToReturn;
  }

  public void add(MovieItem movieItem) { // получаем обьект MovieItem и указываем movieItem

    MovieItem[] tmp = new MovieItem[movies.length + 1];// новый массив длинна которого на 1 больше

    System.arraycopy ( movies, 0, tmp, 0, movies.length ); // копируем фильмы в tmp

    tmp[tmp.length - 1] = movieItem;// добавляем еще 1 фильм

    movies = tmp;// сообщаем что массив фильмов тот который нам нужен
  }

  public MovieItem[] getMovies() {
    int arrayLength;//

    if ( moviesToReturn <= 0 ) moviesToReturn=moviesToReturnDefault;//если дурк задал бредовое зколичество - 0 и меньше то вернем по умолчанию 10
    arrayLength = moviesToReturn;

    if ( moviesToReturn > movies.length ) {//если фильмов меньше чем нужно вернуть
      arrayLength = movies.length;//то возвращаем сколько есть
    }


    MovieItem[] result = new MovieItem[arrayLength];// создаем массив который выдает фильмы для возврата

    for (int i = 0; i < arrayLength; i++) {
      int index = movies.length - i - 1;// фильмы выдаются  в обратном порядке
      result[i] = movies[index];
    }

    return result;
  }
}
