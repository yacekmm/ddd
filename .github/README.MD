## <a name="rebasing"></a> Rebasing

Branches with assignments must be rebased on `main` to reflect new features added to `main` in assignments branches. Use `rebaser.sh` to rebase:
1. Navigate to `Tickets/.github` directory (on Windows use Git Bash)
2. Run `./rebaser.sh` to rebase and push all branches starting with `x-` on `main`