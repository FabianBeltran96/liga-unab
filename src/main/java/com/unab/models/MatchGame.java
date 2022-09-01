package com.unab.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="matches")
public class MatchGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "local_team_id", referencedColumnName = "id")
    private Team localTeam;

    @Getter
    @Setter
    private int goals_local;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitor_team_id", referencedColumnName = "id")
    private Team visitorTeam;

    @Getter
    @Setter
    private int goals_visitor;

    @Getter
    @Setter
    private String dateMatch;

    @Override
    public String toString() {
        return "MatchGame{" +
                "id=" + id +
                ", user=" + user +
                ", localTeam=" + localTeam +
                ", goals_local=" + goals_local +
                ", visitorTeam=" + visitorTeam +
                ", goals_visitor=" + goals_visitor +
                ", dateMatch=" + dateMatch +
                '}';
    }
}
