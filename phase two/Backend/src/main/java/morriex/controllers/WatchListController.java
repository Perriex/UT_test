package morriex.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import morriex.model.urlParam.AddToWatchListModel;
import morriex.model.urlParam.ChangeWatchlistModel;
import morriex.model.urlParam.GetWatchListModel;
import morriex.model.urlParam.RemoveFromWatchListModel;
import morriex.model.view.WatchListModel;
import morriex.commands.AddToWatchList;
import morriex.commands.GetWatchList;
import morriex.commands.RemoveFromWatchList;
import morriex.context.UserContext;

@RestController
public class WatchListController {

    @GetMapping("Watchlist")
    ResponseEntity<WatchListModel> showWatchlist() throws Exception {
        GetWatchListModel model = new GetWatchListModel();
        model.userEmail = UserContext.email;
        GetWatchList command = new GetWatchList();
        WatchListModel watch = command.handle(model);

        return ResponseEntity.ok(watch);
    }

    @PostMapping("Watchlist")
    ResponseEntity<String> addToWatchlist(@RequestBody ChangeWatchlistModel body) throws Exception {
        AddToWatchListModel model = new AddToWatchListModel();
        model.movieId = body.movieId;
        model.userEmail = UserContext.email;
        AddToWatchList command = new AddToWatchList();
        command.handle(model);
        return ResponseEntity.ok("Successfully added to watchlist");
    }

    @DeleteMapping("Watchlist/{movieId}")
    ResponseEntity<String> removeFromWatchlists(@PathVariable Integer movieId) throws Exception {
        RemoveFromWatchListModel model = new RemoveFromWatchListModel();
        model.movieId = movieId;
        model.userEmail = UserContext.email;
        RemoveFromWatchList command = new RemoveFromWatchList();
        command.handle(model);

        return ResponseEntity.ok("Successfully removed from watchlist");
    }
}